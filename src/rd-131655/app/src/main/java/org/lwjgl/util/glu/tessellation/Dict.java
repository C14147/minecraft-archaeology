package org.lwjgl.util.glu.tessellation;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Dict.class */
class Dict {
    DictNode head;
    Object frame;
    DictLeq leq;

    /* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/glu/tessellation/Dict$DictLeq.class */
    public interface DictLeq {
        boolean leq(Object obj, Object obj2, Object obj3);
    }

    private Dict() {
    }

    static Dict dictNewDict(Object frame, DictLeq leq) {
        Dict dict = new Dict();
        dict.head = new DictNode();
        dict.head.key = null;
        dict.head.next = dict.head;
        dict.head.prev = dict.head;
        dict.frame = frame;
        dict.leq = leq;
        return dict;
    }

    static void dictDeleteDict(Dict dict) {
        dict.head = null;
        dict.frame = null;
        dict.leq = null;
    }

    static DictNode dictInsert(Dict dict, Object key) {
        return dictInsertBefore(dict, dict.head, key);
    }

    static DictNode dictInsertBefore(Dict dict, DictNode node, Object key) {
        do {
            node = node.prev;
            if (node.key == null) {
                break;
            }
        } while (!dict.leq.leq(dict.frame, node.key, key));
        DictNode newNode = new DictNode();
        newNode.key = key;
        newNode.next = node.next;
        node.next.prev = newNode;
        newNode.prev = node;
        node.next = newNode;
        return newNode;
    }

    static Object dictKey(DictNode aNode) {
        return aNode.key;
    }

    static DictNode dictSucc(DictNode aNode) {
        return aNode.next;
    }

    static DictNode dictPred(DictNode aNode) {
        return aNode.prev;
    }

    static DictNode dictMin(Dict aDict) {
        return aDict.head.next;
    }

    static DictNode dictMax(Dict aDict) {
        return aDict.head.prev;
    }

    static void dictDelete(Dict dict, DictNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    static DictNode dictSearch(Dict dict, Object key) {
        DictNode node = dict.head;
        do {
            node = node.next;
            if (node.key == null) {
                break;
            }
        } while (!dict.leq.leq(dict.frame, key, node.key));
        return node;
    }
}
