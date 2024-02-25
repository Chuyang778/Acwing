package com.xuechuyang.hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ChuYang
 * @version 1.0
 */
public class ConvertList2Tree {
    public static <V> List<TreeNode<V>> convertListToTree(List<Node<V>> list) {
        List<Node<V>> distinctList = list.stream().distinct().collect(Collectors.toList());
        Map<String, TreeNode<V>> tempMap = new HashMap<>();
        distinctList.forEach(node -> {
            tempMap.put(node.getId(), new TreeNode<V>(node.getId(), new ArrayList<>(), node.getValue()));
        });
        List<TreeNode<V>> resultList = new ArrayList<>();
        distinctList.forEach(node -> {
            TreeNode<V> curParentTreeNode = tempMap.get(node.getParentId());
            TreeNode<V> curTreeNode = tempMap.get(node.getId());
            if (null == curParentTreeNode) {
                resultList.add(curTreeNode);
            } else {
                if (curParentTreeNode.getChildren() == null) {
                    curParentTreeNode.setChildren(new ArrayList<>());
                }
                curParentTreeNode.getChildren().add(curTreeNode);
                resultList.add(curTreeNode);
            }
        });
        return resultList;
    }
}

class Node<V> {
    private String id;

    private String parentId;

    private V value;

    public Node(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Node(String id, String parentId, V value) {
        this.id = id;
        this.parentId = parentId;
        this.value = value;
    }

    public Node() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


class TreeNode<V> {
    private String id;
    private List<TreeNode<V>> children;
    private V value;

    public TreeNode(String id, List<TreeNode<V>> children) {
        this.id = id;
        this.children = children;
    }

    public TreeNode(String id, List<TreeNode<V>> children, V value) {
        this.id = id;
        this.children = children;
        this.value = value;
    }

    public TreeNode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TreeNode<V>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<V>> children) {
        this.children = children;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}