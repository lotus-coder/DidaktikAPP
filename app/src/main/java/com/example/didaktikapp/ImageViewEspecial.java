package com.example.didaktikapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.Objects;

public class ImageViewEspecial extends androidx.appcompat.widget.AppCompatImageView {
    private boolean estaSeleccionado;

    public ImageViewEspecial(Context context) {
        super(context);
        estaSeleccionado = false;
    }

    public ImageViewEspecial(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        estaSeleccionado = false;
    }

    public ImageViewEspecial(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        estaSeleccionado = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageViewEspecial that = (ImageViewEspecial) o;
        return estaSeleccionado == that.estaSeleccionado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estaSeleccionado);
    }

    public boolean isEstaSeleccionado() {
        return estaSeleccionado;
    }

    public void setEstaSeleccionado(boolean estaSeleccionado) {
        this.estaSeleccionado = estaSeleccionado;
    }
}
