package ge.meroag.demoapp.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.meroag.demoapp.R
import ge.meroag.demoapp.data.models.People
import kotlinx.android.synthetic.main.people_list_item.view.*

class PeopleListAdapter(private val onLongClickListener: View.OnLongClickListener): RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {

    private var mList = emptyList<People>()

    fun setData(people:List<People>){
        mList = people
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.people_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = mList[position]
        holder.mUser.text =  currentItem.firstName +" " + currentItem.lastName
        holder.mStatus.text = currentItem.statusMessage
        holder.mCard.tag = currentItem
        holder.mCard.setOnLongClickListener(onLongClickListener)

        when(currentItem.statusIcon.lowercase()){
            "online"-> holder.mStatusImg.setColorFilter(Color.GREEN)
            "offline"-> holder.mStatusImg.setColorFilter(Color.GRAY)
            "busy"-> holder.mStatusImg.setColorFilter(Color.RED)
            "away"-> holder.mStatusImg.setColorFilter(Color.YELLOW)
            "callforwarding"->holder.mStatusImg.setColorFilter(Color.BLUE)
        }
    }

    override fun getItemCount(): Int = mList.size


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mUser = itemView.lb_user
        val mStatus = itemView.lb_status
        val mStatusImg = itemView.img_status
        val mCard = itemView.card_people
    }
}