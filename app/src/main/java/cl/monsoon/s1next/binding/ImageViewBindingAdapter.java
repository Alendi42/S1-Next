package cl.monsoon.s1next.binding;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cl.monsoon.s1next.R;

public final class ImageViewBindingAdapter {

    private ImageViewBindingAdapter() {}

    @BindingAdapter("imageDrawable")
    public static void setImageDrawable(ImageView imageView, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            @SuppressLint("PrivateResource") @ColorInt int rippleColor = ContextCompat.getColor(
                    imageView.getContext(), R.color.ripple_material_dark);
            // add ripple effect if API >= 21
            RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(rippleColor),
                    drawable, null);
            imageView.setImageDrawable(rippleDrawable);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }


    @BindingAdapter("captchaPicUrl")
    public static void loadImage(ImageView imageView, String captchaPicUrl) {
        imageView.setOnClickListener(v -> loadCaptchaPic(imageView, captchaPicUrl));
        loadCaptchaPic(imageView, captchaPicUrl);
    }

    private static void loadCaptchaPic(ImageView imageView, String captchaPicUrl) {
        Glide.with(imageView.getContext())
                .load(captchaPicUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    @BindingAdapter({"emoticonDrawableRequestBuilder", "emoticonImagePath"})
    public static void loadEmoticon(ImageView imageView,
                                    DrawableRequestBuilder<Uri> emoticonDrawableRequestBuilder,
                                    String emoticonImagePath) {
        emoticonDrawableRequestBuilder.load(Uri.parse(emoticonImagePath)).into(imageView);
    }
}
