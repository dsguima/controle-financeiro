package br.com.controlefinanceiro.firebase.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import br.com.controlefinanceiro.firebase.FirebaseControleFinanceiro;
import br.com.controlefinanceiro.helper.CollectionHelper;
import br.com.controlefinanceiro.helper.ConstantHelper;
import br.com.controlefinanceiro.model.entidade.Produto;

public class ProdutoRepository extends BaseRepository<Produto> {

    static String TAG = "PPRODUTO_REPOSITORY";

    private String collection = CollectionHelper.COLLECTION_PRODUTO;
    protected FirebaseFirestore db;
    public Produto object;

    /**
     * Constructor
     */

    public ProdutoRepository() {
        super(CollectionHelper.COLLECTION_PRODUTO, Produto.class);
    }

    /**
     *
     * @param entity
     * @return Task<Void>
     * @throws Exception
     */
    public Task<Void> saveRefId(Produto entity) throws Exception {

        this.db = FirebaseControleFinanceiro.getDatabase();

        DocumentReference ref = db.collection(collection).document();
        String myId = ref.getId();

        this.object = entity;
        object.key = myId;
        object.status = ConstantHelper.ATIVO;

        return db.collection(collection).document(myId).set(object);
    }
}
