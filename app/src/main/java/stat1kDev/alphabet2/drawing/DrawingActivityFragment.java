package stat1kDev.alphabet2.drawing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;
import stat1kDev.alphabet2.R;
import stat1kDev.alphabet2.activity.MainActivity;
import stat1kDev.alphabet2.utilities.ActivityUtilities;


public class DrawingActivityFragment extends Fragment {

    private DrawingView drawingView;
    private float acceleration;
    private float currentAcceleration;
    private float lastAcceleration;
    private boolean dialogOnScreen = false;

    private static  final int ACCELERATION_THRESHOLD = 600000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_drawing_activity, container, false);
        setHasOptionsMenu(true);

        drawingView = view.findViewById(R.id.drawingView);

        acceleration = 0.00f;
        currentAcceleration = SensorManager.GRAVITY_EARTH;
        lastAcceleration = SensorManager.GRAVITY_EARTH;
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        enableAccelerometerListening();
    }

    private void enableAccelerometerListening(){
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        disableAccelerometerListening();
    }

    private void disableAccelerometerListening(){
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.unregisterListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(!dialogOnScreen){
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                lastAcceleration = currentAcceleration;
                currentAcceleration = x * x + y * y + z * z;
                acceleration = currentAcceleration * (currentAcceleration - lastAcceleration);

                if (acceleration > ACCELERATION_THRESHOLD)
                    getDrawingView().clear();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.drawing_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(getActivity(), MainActivity.class, true);
                return true;
            case R.id.clear:
                getDrawingView().clear();
                return true;
            case R.id.color:
                openColorPicker();
                return true;
            case R.id.line_width:
                LineWidthDialogFragment widthDialogFragment = new LineWidthDialogFragment();
                widthDialogFragment.show(getFragmentManager(), "line width dialog");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public DrawingView getDrawingView() {
        return drawingView;
    }

    public void setDialogOnScreen(boolean visible){
        dialogOnScreen = visible;
    }

    public void openColorPicker() {
        final ColorPicker colorPicker = new ColorPicker(getActivity());
        ArrayList<String> colors = new ArrayList<>();
        colors.add("#00FFFF");
        colors.add("#0000FF");
        colors.add("#FF00FF");
        colors.add("#808080");
        colors.add("#008000");
        colors.add("#00FF00");
        colors.add("#800000");
        colors.add("#000080");
        colors.add("#808000");
        colors.add("#800080");
        colors.add("#FF0000");
        colors.add("#C0C0C0");
        colors.add("#008080");
        colors.add("#FFFF00");
        colors.add("#FFFFFF");
        colors.add("#000000");

        colorPicker.setColors(colors)
                .setColumns(4)
                .setTitle("Цвет")
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        drawingView.setDrawingColor(color);
                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
    }


}
