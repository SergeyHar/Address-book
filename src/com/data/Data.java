package com.data;

import java.util.List;

public interface Data {
    void fileWriter(String path, Object object);
    void removeFileArgument(String path, Object object);
    List<Object> fileReader(String path);

}
