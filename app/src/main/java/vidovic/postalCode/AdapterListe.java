package vidovic.postalCode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    private List<Place> placesList;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }

    public  AdapterListe(Context context){
        layoutInflater = LayoutInflater.from(context);
    }



    public void setPlacesList(List<Place> placesList) {
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.red_liste,parent,false);

        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Place place = placesList.get(position);
        holder.tvIme.setText(place.getPlace_name());
        holder.tvPrezime.setText(place.getState_abbreviation());
    }

    @Override
    public int getItemCount() {
        if(placesList ==null){
            return 0;
        }
        return placesList.size();
    }


    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvIme;
        private TextView tvPrezime;

        public Red(@NonNull View itemView){
            super(itemView);
            tvIme = itemView.findViewById(R.id.tvIme);
            tvPrezime=itemView.findViewById(R.id.tvPrezime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickInterface==null){
                return;
            }
            itemClickInterface.onItemClick(placesList.get(getAdapterPosition()));
        }
    }

    public interface ItemClickInterface{
        void onItemClick(Place place);
    }

}
