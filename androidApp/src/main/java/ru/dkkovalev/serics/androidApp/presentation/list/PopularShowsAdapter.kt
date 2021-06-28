package ru.dkkovalev.serics.androidApp.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import ru.dkkovalev.serics.androidApp.R
import ru.dkkovalev.serics.androidApp.databinding.ItemShowBinding
import ru.dkkovalev.serics.shared.data.entity.model.Show

class PopularShowsAdapter(private val glideRequestManager: RequestManager) :
    ListAdapter<Show, MoviesViewHolder>(MoviesUtilCallback()),
    ListPreloader.PreloadModelProvider<Show> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        glideRequestManager
    )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getPreloadItems(position: Int): MutableList<Show> {
        return currentList.subList(position, position + 1)
    }

    override fun getPreloadRequestBuilder(item: Show): RequestBuilder<*> {
        return glideRequestManager.load(item.posterUrl)
    }
}

class MoviesViewHolder(
    private val itemMovieBinding: ItemShowBinding,
    private val glideRequestManager: RequestManager
) : RecyclerView.ViewHolder(itemMovieBinding.root) {

    private val cornerRadius = itemView.resources.getDimension(R.dimen.dimen_16)

    fun bind(item: Show) = with(item) {
        itemMovieBinding.showTitle.text = title
        glideRequestManager.load(item.posterUrl)
            .transform(
                MultiTransformation(
                    CenterCrop(),
                    GranularRoundedCorners(
                        cornerRadius,
                        cornerRadius,
                        0f,
                        0f
                    )
                )
            )
            .into(itemMovieBinding.showPoster)
    }


}

class MoviesUtilCallback : DiffUtil.ItemCallback<Show>() {
    override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean = true
    override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean = true
}