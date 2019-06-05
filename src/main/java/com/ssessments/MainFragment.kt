package com.ssessments


import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssessments.data.getNewsItemArray


class mainFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root=inflater.inflate(R.layout.fragment_main, container, false)



        val myToolbar=root.findViewById<Toolbar>(R.id.toolbar)
        val mainActivity=activity as androidx.appcompat.app.AppCompatActivity
        mainActivity.setSupportActionBar(myToolbar)

        recyclerView=root.findViewById(R.id.mainRecView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter=NewsAdapter(getNewsItemArray())
        recyclerView.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))



        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings,menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        this.findNavController().navigate(R.id.mySettingsFragment)
        //return super.onOptionsItemSelected(item)
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
