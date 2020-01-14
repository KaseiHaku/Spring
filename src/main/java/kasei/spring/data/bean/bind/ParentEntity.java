package kasei.spring.data.bean.bind;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ParentEntity {

    private String str;
    private List<Integer> list;
    private Map<String, Boolean> map;
    private ChildEntity composed;

}
