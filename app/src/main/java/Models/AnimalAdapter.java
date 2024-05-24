package Models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudioe8.Lab1RecyclerView2;
import com.example.androidstudioe8.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalviewHolder> {

    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimalviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new AnimalviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AnimalviewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.textViewId.setText(String.valueOf(animal.getId()));
        holder.textViewName.setText(animal.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context,
                    Lab1RecyclerView2.class);
            intent.putExtra("id", animal.getId());
            intent.putExtra("name", animal.getName());
            intent.putExtra("description",
                    animal.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    static class AnimalviewHolder extends RecyclerView.ViewHolder{
        TextView textViewId;
        TextView textViewName;
        public AnimalviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName =
                    itemView.findViewById(R.id.textViewName);
        }
    }
}
