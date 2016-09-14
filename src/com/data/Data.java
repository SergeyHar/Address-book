package com.data;

import java.util.List;

public interface Data<T> {
    void fileWriter(String path, T t);
    void removeFileArgument(String path, T t);
    List<T> fileReader(String path);
    void clearingFile(String path);

}
