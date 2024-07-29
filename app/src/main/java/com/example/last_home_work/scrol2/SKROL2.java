package com.example.last_home_work.scrol2;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_home_work.Container2;
import com.example.last_home_work.databinding.ItemProduct2Binding;

import java.util.ArrayList;

public class SKROL2 extends RecyclerView.Adapter<SKROL2.ScrolViewHolder2> {
    private ArrayList<Container2> container2;
    private int selectedPosition = -1;

    public SKROL2(ArrayList<Container2> container2) {
        this.container2 = container2;
    }

    @NonNull
    @Override
    public ScrolViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScrolViewHolder2(ItemProduct2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScrolViewHolder2 holder, int position) {
        holder.bind(container2.get(position), position);
    }

    @Override
    public int getItemCount() {
        return container2.size();
    }

    class ScrolViewHolder2 extends RecyclerView.ViewHolder {
        public ItemProduct2Binding viewBinding;

        public ScrolViewHolder2(@NonNull ItemProduct2Binding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }

        public void bind(Container2 container2, int position) {
            viewBinding.textIcon.setText(container2.getTextIcon());
            Glide.with(itemView.getContext()).load(container2.getIcon()).into(viewBinding.icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedPosition != getAdapterPosition()) {
                        int previousPosition = selectedPosition;
                        selectedPosition = getAdapterPosition();
                        notifyItemChanged(previousPosition);
                        notifyItemChanged(selectedPosition);
                    }
                }
            });

            changeColors(position == selectedPosition);
            animateScale(itemView, position == selectedPosition ? 1.1f : 1.0f);
        }

        private void animateScale(View v, float endScale) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, "scaleX", endScale);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, "scaleY", endScale);
            scaleX.setDuration(200);
            scaleY.setDuration(200);
            scaleX.start();
            scaleY.start();
        }

        private void changeColors(boolean isSelected) {
            if (isSelected) {
                viewBinding.textIcon.setTextColor(Color.BLACK);
                viewBinding.icon.setColorFilter(Color.RED);
            } else {
                viewBinding.textIcon.setTextColor(Color.GRAY);
                viewBinding.icon.clearColorFilter();
            }
        }
    }
}
