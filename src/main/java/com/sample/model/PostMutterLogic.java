package com.sample.model;

import java.util.List;

public class PostMutterLogic {
    public PostMutterLogic(){}
    public void execute(Mutter mutter, List<Mutter> mutterList) {
        mutterList.add(0, mutter);
    }
}
