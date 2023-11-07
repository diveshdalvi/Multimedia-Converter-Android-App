package com.multimediaconvertor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.model.History;

public class page_13th  extends AppCompatActivity {
        private static final int REQUEST_IMAGE_PICK = 1;

        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.page_13th);
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());

                ImageButton backButton = findViewById(R.id.back_btn);
                ImageButton settingButton = findViewById(R.id.setting_btn);
                Button upload_image_btn = findViewById(R.id.upload_image_btn);

                backButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                finish();
                        }
                });

                settingButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openSetting();
                        }
                });

                Button outputFile = findViewById(R.id.output_btn);
                outputFile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                myDBHandler db = new myDBHandler (page_13th.this);
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                                String currentDate = dateFormat.format(calendar.getTime());
                                History history  = new History();
                                history.setName("Compress Image");
                                history.setPath("android/path/path");
                                history.setDate(currentDate);
                                db.addHistory(history);
                                Log.d("dbHistory","Name "+history.getName());
                        }
                });
                upload_image_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(intent, REQUEST_IMAGE_PICK);
                        }
                });
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK) {
                        Uri selectedImageUri = data.getData();
                        try {
                                // Load the selected image
                                Bitmap originalBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImageUri));

                                // Compress the image
                                Bitmap compressedBitmap = compressImage(originalBitmap);

                                // Save the compressed image
                                File imageFile = saveCompressedImage(compressedBitmap);

                                // Allow the user to download the compressed image
                                Toast.makeText(this, "Image compressed and saved.", Toast.LENGTH_SHORT).show();
                                // Implement the download functionality here or provide a download button for the user.
                                // You can use the imageFile to share or download the image.
                        } catch (IOException e) {
                                e.printStackTrace();
                                Toast.makeText(this, "Error compressing and saving image.", Toast.LENGTH_SHORT).show();
                        }
                }
        }
        private Bitmap compressImage(Bitmap originalBitmap) {
                // Implement your image compression logic here (e.g., using BitmapFactory.Options).
                // This code provides a basic example; you may need to adjust compression settings.
                int quality = 50; // Adjust the quality (0-100) as needed.
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                originalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                return BitmapFactory.decodeStream(new ByteArrayInputStream(outputStream.toByteArray()));
        }
        private File saveCompressedImage(Bitmap compressedBitmap) throws IOException {
                // Create a directory for compressed images if it doesn't exist
                File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "CompressedImages");
                if (!storageDir.exists()) {
                        storageDir.mkdirs();
                }

                // Generate a unique file name using a timestamp
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "compressed_image_" + timestamp + ".jpg";

                // Create the File object for the image
                File imageFile = new File(storageDir, imageFileName);

                // Save the compressed image to the file
                FileOutputStream fos = new FileOutputStream(imageFile);
                compressedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
                fos.close();

                // Add the image to the media store
                MediaScannerConnection.scanFile(this, new String[]{imageFile.getAbsolutePath()}, null, null);

                return imageFile;
        }



        private void openSetting() {
                Intent intent = new Intent(this, settingPage.class);
                startActivity(intent);

        }
        // After saving the compressed image using your existing code:


}
