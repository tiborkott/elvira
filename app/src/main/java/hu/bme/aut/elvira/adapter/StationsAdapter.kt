package hu.bme.aut.elvira.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.elvira.R
import hu.bme.aut.elvira.data.Stations

class StationsAdapter(private var stations : Stations) : RecyclerView.Adapter<StationsAdapter.StationsViewHolder>(){

    inner class StationsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val tvDetailsArrivalTime : TextView = itemView.findViewById(R.id.tvDetailsArrivalTime)
        val tvStationName : TextView = itemView.findViewById(R.id.tvStationName)
        val tvDetailsDepartureTime : TextView = itemView.findViewById(R.id.tvDetailsDepartureTime)
        val tvKm : TextView = itemView.findViewById(R.id.tvKm)
        val tvTrack : TextView = itemView.findViewById(R.id.tvTrack)
    }


    override fun onBindViewHolder(holder: StationsViewHolder, position: Int) {


        if(stations.stations[position].schedule.arrival.isEmpty()){
            holder.tvDetailsArrivalTime.text = "-"
        }else{
            holder.tvDetailsArrivalTime.text = stations.stations[position].schedule.arrival
        }

        holder.tvStationName.text = stations.stations[position].station.text

        if(stations.stations[position].schedule.departure.isEmpty()){
            holder.tvDetailsDepartureTime.text = "-"
        }else{
            holder.tvDetailsDepartureTime.text = stations.stations[position].schedule.departure
        }

        holder.tvKm.text = stations.stations[position].km

        if(stations.stations[position].platform.isEmpty()){
            holder.tvTrack.text = "-"
        }else{
            holder.tvTrack.text = stations.stations[position].platform
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
        return StationsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_station_list,parent,false))
    }

    override fun getItemCount(): Int {
        return stations.stations.size
    }
}