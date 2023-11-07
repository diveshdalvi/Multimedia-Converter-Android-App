package com.multimediaconvertor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import com.multimediaconvertor.Data.myDBHandler;
import com.multimediaconvertor.model.History;

public class page_12th extends AppCompatActivity {
    private static final int REQUEST_IMAGE_PICK = 1;
    private Button upload_image_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_12th);
        upload_image_btn = findViewById(R.id.upload_image_btn);

        ImageButton backButton = findViewById(R.id.back_btn);
        ImageButton settingButton = findViewById(R.id.setting_btn);

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
        upload_image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImagesFromGallery();
            }
        });

        Button outputFile = findViewById(R.id.output_btn);
        outputFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBHandler db = new myDBHandler (page_12th.this);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String currentDate = dateFormat.format(calendar.getTime());
                History history  = new History();
                history.setName("Image To PDF");
                history.setPath("android/path/path");
                history.setDate(currentDate);
                db.addHistory(history);
                Log.d("dbHistory","Name "+history.getName());
            }
        });
    }
    private void pickImagesFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Images"), REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            if (data != null) {
                List<Uri> imageUris = new ArrayList<>();
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();
                    for (int i = 0; i < count; i++) {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageUris.add(imageUri);
                    }
                } else if (data.getData() != null) {
                    Uri imageUri = data.getData();
                    imageUris.add(imageUri);
                }

                createPdfFromImages(imageUris);
            }
        }
    }

    private void createPdfFromImages(List<Uri> imageUris) {
        PdfDocument pdfDocument = new PdfDocument();
        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String timestamp = timestampFormat.format(new Date());
        String pdfFileName = "converted_images_" + timestamp + ".pdf";

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(612, 792, imageUris.size()).create();

        for (int i = 0; i < imageUris.size(); i++) {
            Uri imageUri = imageUris.get(i);
            Bitmap bitmap = loadBitmapFromUri(imageUri);

            if (bitmap != null) {
                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                int width = page.getCanvas().getWidth();
                int height = page.getCanvas().getHeight();

                // Calculate the scale factor to fit the image within the page
                float scale = Math.min((float) width / bitmap.getWidth(), (float) height / bitmap.getHeight());

                // Create a scaled and centered bitmap
                int scaledWidth = (int) (bitmap.getWidth() * scale);
                int scaledHeight = (int) (bitmap.getHeight() * scale);
                int left = (width - scaledWidth) / 2;
                int top = (height - scaledHeight) / 2;

                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                matrix.postTranslate(left, top);

                page.getCanvas().drawBitmap(bitmap, matrix, null);
                pdfDocument.finishPage(page);
            }
        }

        // Save the PDF to the Documents directory in external storage
        File pdfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), pdfFileName);


        try {
            pdfFile.getParentFile().mkdirs(); // Ensure the parent directories exist
            pdfDocument.writeTo(new FileOutputStream(pdfFile));
            Toast.makeText(this, "PDF created and saved to " + pdfFile.getPath(), Toast.LENGTH_SHORT).show();

            // Open the saved PDF using an Intent
            // Open the saved PDF using an Intent



        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving PDF: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        pdfDocument.close();
    }



    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Bitmap loadBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void openSetting() {
        Intent intent = new Intent(this, settingPage.class);
        startActivity(intent);

    }
}
