package br.com.controlefinanceiro.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import br.com.controlefinanceiro.R;
import br.com.controlefinanceiro.helper.ConstantHelper;
import br.com.controlefinanceiro.model.entidade.Despesa;
import br.com.controlefinanceiro.viewmodel.DespesaViewModel;

public class DespesaAdapter extends RecyclerView.Adapter<DespesaAdapter.DespesaViewHolder> {


    public static String TAG = "DespesaAdapter";

    private List<Despesa> listDespesa;
    private Context context;
    private DespesaViewModel mViewmodel;


    public DespesaAdapter(List<Despesa> listDespesa, DespesaViewModel viewmodel) {
        this.listDespesa = listDespesa;
        this.mViewmodel = viewmodel;
    }

    @Override
    public DespesaAdapter.DespesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_despesa, parent, false);
        DespesaAdapter.DespesaViewHolder viewHolder = new DespesaAdapter.DespesaViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final DespesaAdapter.DespesaViewHolder holder, int position) {

        final Despesa mItem = listDespesa.get(position);
        holder.descricaoDespesa.setText(mItem.descricao);
        holder.valorDespesa.setText(String.valueOf(mItem.valor));
        //holder.mesDespesa.setText(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(mItem.dataUltimaAtualizacao));
        holder.mesDespesa.setText(Arrays.asList(ConstantHelper.meses).get(mItem.mes));
        holder.contaDespesa.setText(Arrays.asList(ConstantHelper.conta).get(mItem.conta));
        holder.responsavelDespesa.setText(Arrays.asList(ConstantHelper.responsavel).get(mItem.responsavel));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewmodel.delete(mItem);
                listDespesa.remove(mItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public int getItemCount() {
        return listDespesa.size();
    }

    public static class DespesaViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView descricaoDespesa;
        public AppCompatTextView mesDespesa;
        public AppCompatTextView valorDespesa;
        public AppCompatTextView responsavelDespesa;
        public AppCompatTextView contaDespesa;
        public AppCompatImageButton delete;

        public DespesaViewHolder(View itemView) {
            super(itemView);
            this.descricaoDespesa = (AppCompatTextView) itemView.findViewById(R.id.descricaoDespesa);
            this.mesDespesa = (AppCompatTextView) itemView.findViewById(R.id.mesDespesa);
            this.valorDespesa = (AppCompatTextView) itemView.findViewById(R.id.valorDespesa);
            this.responsavelDespesa = (AppCompatTextView) itemView.findViewById(R.id.responsavelDespesa);
            this.contaDespesa = (AppCompatTextView) itemView.findViewById(R.id.contaDespesa);
            this.delete = (AppCompatImageButton) itemView.findViewById(R.id.delete);
        }
    }
}