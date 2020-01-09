package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisConfig;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureConfig;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;

import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.databinding.demo.R;

public class CameraXActivity extends AppCompatActivity {

    private TextView startCamera;
    private TextureView textureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_x);

        startCamera = findViewById(R.id.startCamera);
        textureView = findViewById(R.id.textureView);
        startCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCameraX();
            }
        });
    }

    private void initCameraX() {
        PreviewConfig previewConfig = new PreviewConfig.Builder().build();
        ImageCaptureConfig imageCaptureConfig =
                new ImageCaptureConfig.Builder().build();

        ImageCapture imageCapture = new ImageCapture(imageCaptureConfig);
        Preview preview = new Preview(previewConfig);

        imageAnalysis();

        preview.setOnPreviewOutputUpdateListener(
                new Preview.OnPreviewOutputUpdateListener() {
                    @Override
                    public void onUpdated(Preview.PreviewOutput previewOutput) {
                        // The output data-handling is configured in a listener.
                        textureView.setSurfaceTexture(previewOutput.getSurfaceTexture());
                        // Your custom code here.
                    }
                });


        // The use case is bound to an Android Lifecycle with the following code.
        CameraX.bindToLifecycle(this, imageCapture, imageAnalysis,preview);
    }

    private ImageAnalysis imageAnalysis;

    private void imageAnalysis() {
        ImageAnalysisConfig config =
                new ImageAnalysisConfig.Builder()
                        .setTargetResolution(new Size(1280, 720))
                        .setImageReaderMode(ImageAnalysis.ImageReaderMode.ACQUIRE_LATEST_IMAGE)
                        .build();

        imageAnalysis = new ImageAnalysis(config);

        imageAnalysis.setAnalyzer(
                new ImageAnalysis.Analyzer() {
                    @Override
                    public void analyze(ImageProxy image, int rotationDegrees) {
                        // insert your code here.
                        //CameraX 会生成 YUV_420_888 格式的图片。
                        Log.e("XLog", "imageInfo:" + image.toString());
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CameraX.unbindAll();
    }
}
