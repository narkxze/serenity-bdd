package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder(toBuilder = true)
public class PetStore {
    private int id;
    private Map<String,Object> category;
    private String name;
    private List<String> photoUrls;
    private List<Map<String,Object>> tags;
    private String status;



}
