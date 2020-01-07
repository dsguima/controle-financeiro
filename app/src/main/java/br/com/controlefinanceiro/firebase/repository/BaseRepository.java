package br.com.controlefinanceiro.firebase.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import br.com.controlefinanceiro.firebase.FirebaseControleFinanceiro;

public abstract class BaseRepository<T> {

    static String TAG = "FIREBASE_REPOSITORY";

    private String collection;
    protected FirebaseFirestore db;
    private Class<T> clazz;

    /**
     * Constructor
     *
     * @param collection
     * @param clazz
     */
    public BaseRepository(String collection, Class<T> clazz) {
        this.db = FirebaseControleFinanceiro.getDatabase();
        this.collection = collection;
        this.clazz = clazz;
    }

    /**
     * Get all documents by collection
     *
     * @return
     * @throws Exception
     */
    public Task<QuerySnapshot> getAll() throws Exception {
        return db.collection(collection).get();
    }

    /**
     * Delete a document
     *
     * @param key
     * @return
     */
    public Task<Void> delete(final String key) {
        return db.collection(collection).document(key).delete();
    }
}
