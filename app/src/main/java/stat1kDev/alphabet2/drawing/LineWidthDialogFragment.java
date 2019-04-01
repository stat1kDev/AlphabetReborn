package stat1kDev.alphabet2.drawing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import stat1kDev.alphabet2.R;

public class LineWidthDialogFragment extends DialogFragment {
    private ImageView widthImageView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View lineWidthDialogView = getActivity().getLayoutInflater().inflate(R.layout.fragment_line_width_dialog, null);
        builder.setView(lineWidthDialogView);
        widthImageView = lineWidthDialogView.findViewById(R.id.widthImageView);

        final DrawingView drawingView = getDrawingFragment().getDrawingView();
        final SeekBar widthSeekBar = lineWidthDialogView.findViewById(R.id.widthSeekBar);
        widthSeekBar.setOnSeekBarChangeListener(lineWidthChanged);
        widthSeekBar.setProgress(drawingView.getLineWidth());

        builder.setPositiveButton(R.string.button_set_line_width, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                drawingView.setLineWidth(widthSeekBar.getProgress());
            }
        });
        return builder.create();
    }

    private DrawingActivityFragment getDrawingFragment(){
        return (DrawingActivityFragment) getFragmentManager().findFragmentById(R.id.drawingFragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DrawingActivityFragment fragment = getDrawingFragment();

        if(fragment != null)
            fragment.setDialogOnScreen(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DrawingActivityFragment fragment = getDrawingFragment();
        if(fragment != null)
            fragment.setDialogOnScreen(false);
    }

    private final SeekBar.OnSeekBarChangeListener lineWidthChanged = new SeekBar.OnSeekBarChangeListener() {
        final Bitmap bitmap = Bitmap.createBitmap(
                400, 100, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Paint p = new Paint();
            p.setColor(getDrawingFragment().getDrawingView().getDrawingColor());
            p.setStrokeCap(Paint.Cap.ROUND);
            p.setStrokeWidth(progress);

            bitmap.eraseColor(getResources().getColor(android.R.color.transparent, getContext().getTheme()));
            canvas.drawLine(30, 50, 370, 50, p);
            widthImageView.setImageBitmap(bitmap);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}