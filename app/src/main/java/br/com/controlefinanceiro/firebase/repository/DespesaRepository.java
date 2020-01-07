package br.com.controlefinanceiro.firebase.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import br.com.controlefinanceiro.firebase.FirebaseControleFinanceiro;
import br.com.controlefinanceiro.helper.CollectionHelper;
import br.com.controlefinanceiro.model.entidade.Despesa;

public class DespesaRepository extends BaseRepository<Despesa> {

    static String TAG = "DESPESA_REPOSITORY";

    private String collection = CollectionHelper.COLLECTION_DESPESA;
    protected FirebaseFirestore db;
    public Despesa object;

    /**
     * Constructor
     */
    public DespesaRepository() {
        super(CollectionHelper.COLLECTION_DESPESA, Despesa.class);
    }

    /**
     *
     * @param entity
     * @return Task<Void>
     * @throws Exception
     */
    public Task<Void> saveRefId(Despesa entity) throws Exception {

        this.db = FirebaseControleFinanceiro.getDatabase();

        DocumentReference ref = db.collection(collection).document();
        String myId = ref.getId();

        this.object = entity;
        object.key = myId;

        return db.collection(collection).document(myId).set(object);
    }
}
