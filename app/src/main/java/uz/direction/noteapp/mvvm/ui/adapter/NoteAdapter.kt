package uz.direction.noteapp.mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.direction.noteapp.R
import uz.direction.noteapp.mvvm.model.Note

class NoteAdapter(
    private val noteList: List<Note>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteVH>() {
    class NoteVH(
        view: View,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val title = itemView.findViewById<TextView>(R.id.titleOfNote)
        private val text = itemView.findViewById<TextView>(R.id.textOfNote)
        private val date = itemView.findViewById<TextView>(R.id.dateOfNote)

        init {
            view.setOnClickListener(this)
        }

        fun onBind(note: Note) {
            title.text = note.title
            text.text = note.text
            date.text = note.date
        }

        override fun onClick(p0: View?) {
            val position = bindingAdapterPosition
            onItemClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return NoteVH(view, onItemClick)
    }

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        val note = noteList[position]
        holder.onBind(note)
    }

    override fun getItemCount() = noteList.size
}


