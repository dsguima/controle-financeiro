package br.com.controlefinanceiro.firebase.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import br.com.controlefinanceiro.firebase.FirebaseControleFinanceiro;
import br.com.controlefinanceiro.helper.CollectionHelper;
import br.com.controlefinanceiro.helper.ConstantHelper;
import br.com.controlefinanceiro.model.entidade.Rota;

public class RotaRepository extends BaseRepository<Rota> {

    static String TAG = "ROTA_REPOSITORY";

    private String collection = CollectionHelper.COLLECTION_ROTA;
    protected FirebaseFirestore db;
    public Rota object;

    /**
     * Constructor
     */

    public RotaRepository() {
        super(CollectionHelper.COLLECTION_ROTA, Rota.class);
    }

    /**
     *
     * @param entity
     * @return Task<Void>
     * @throws Exception
     */
    public Task<Void> saveRefId(Rota entity) throws Exception {

        this.db = FirebaseControleFinanceiro.getDatabase();

        DocumentReference ref = db.collection(collection).document();
        String myId = ref.getId();

        this.object = entity;
        object.key = myId;
        object.status = ConstantHelper.ATIVO;

        return db.collection(collection).document(myId).set(object);
    }
}
