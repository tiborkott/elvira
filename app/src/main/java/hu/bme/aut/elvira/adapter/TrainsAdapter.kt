package hu.bme.aut.elvira.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.elvira.R
import hu.bme.aut.elvira.data.Timetable
import kotlinx.android.synthetic.main.item_train_list.view.*


class TrainsAdapter(private var trains : List<Timetable>) : RecyclerView.Adapter<TrainsAdapter.TrainsViewHolder>(){

    private lateinit var clickListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        clickListener = listener
    }

    inner class TrainsViewHolder(itemView : View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val tvDepartureTime : TextView = itemView.findViewById(hu.bme.aut.elvira.R.id.tvDepartureTime)
        val tvArrivalTime : TextView = itemView.findViewById(hu.bme.aut.elvira.R.id.tvArrivalTime)
        val tvFrom : TextView = itemView.findViewById(hu.bme.aut.elvira.R.id.tvFrom)
        val tvTo : TextView = itemView.findViewById(hu.bme.aut.elvira.R.id.tvTo)
        val tvTrainLabel : TextView = itemView.findViewById(R.id.tvTrainLabel)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }


    override fun getItemCount(): Int {
        return trains.size
    }

    override fun onBindViewHolder(holder: TrainsViewHolder, position: Int) {

        val detailsSize = trains[position].details.size

        var label =  trains[position].details[0].train_info.code  + ' ' + trains[position].details[0].train_info.info

        label = label.substringBefore('(')
        if(label.contains("IC")){
            label = label.replace("IC","Intercity")
            val v = holder.itemView.findViewById(R.id.tvTrainLabel) as TextView
            v.setBackgroundResource(R.drawable.train_intercity_background)
            if(label.contains("Intercity") && trains[position].type  == "fast" ){
                label = label.replace("Intercity","Gyorsvonat")
                val v = holder.itemView.findViewById(R.id.tvTrainLabel) as TextView
                v.setBackgroundResource(R.drawable.train_fast_background)
            }
        }

        if(label.contains("zónázó") || label.contains("személy")){
            label = label.replace("zónázó", "személyvonat")
            val v = holder.itemView.findViewById(R.id.tvTrainLabel) as TextView
            v.setBackgroundResource(R.drawable.train_passenger_background)
            v.tvTrainLabel.setTextColor(v.resources.getColor(R.color.gray))
        }

        if(label.contains("sebes")){
            label = label.replace("sebes","Sebesvonat")
            val v = holder.itemView.findViewById(R.id.tvTrainLabel) as TextView
            v.setBackgroundResource(R.drawable.train_through_background)
        }


        holder.tvDepartureTime.text = trains[position].starttime
        holder.tvArrivalTime.text = trains[position].destinationtime
        holder.tvFrom.text = trains[position].details[0].from
        holder.tvTo.text = trains[position].details[detailsSize-1].from
        holder.tvTrainLabel.text = label
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_train_list,parent,false)
        return TrainsViewHolder(view, clickListener)
    }

}
