package com.oatworks.Service;

import com.oatworks.model.TodoData;
import com.oatworks.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}
