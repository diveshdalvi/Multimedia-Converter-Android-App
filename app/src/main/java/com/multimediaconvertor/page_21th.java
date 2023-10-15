package com.multimediaconvertor;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.view.UCropView;
import java.io.File;
public class page_21th extends AppCompatActivity {
    private UCropView uCropView;
    private Button cropButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_21th);

        // Get the source and destination URIs from your intent or other source
        Uri sourceUri = getIntent().getParcelableExtra("sourceUri");
        Uri destinationUri = Uri.fromFile(new File(getCacheDir(), "cropped_image.jpg"));

//        // Create a UCrop instance and set your options
//        UCrop uCrop = UCrop.of(sourceUri, destinationUri);
//        uCrop.withOptions(options);  // Apply your crop options here
//
//        // Start the cropping activity
//        uCrop.start(ImageCropActivity.this);
    }
}
