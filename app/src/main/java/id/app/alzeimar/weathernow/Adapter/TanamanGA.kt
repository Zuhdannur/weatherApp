package id.app.alzeimar.weathernow.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import id.app.alzeimar.weathernow.Model.Tanaman
import id.app.alzeimar.weathernow.R
import kotlinx.android.synthetic.main.detail_item_tanaman.*
import kotlinx.android.synthetic.main.item_tanaman.view.*

class TanamanGA : BaseAdapter {
    var contex:Context? = null
    var tanamanList = ArrayList<Tanaman>()
    constructor(contex:Context,tanamanList:ArrayList<Tanaman>):super(){
        this.contex = contex
        this.tanamanList = tanamanList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val tanaman  = this.tanamanList[position]

        var inflator = contex!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var tanamanView = inflator.inflate(R.layout.item_tanaman,null)

        tanamanView.nama_tanaman.text = tanaman.kota
        tanamanView.jenis_tanah.text = tanaman.nama
        return tanamanView
    }

    override fun getItem(position: Int): Any {
            return tanamanList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return tanamanList.size
    }
}