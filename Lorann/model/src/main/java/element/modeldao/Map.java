package element.modeldao;

class Map extends Entity{

    private int     id;
    private String  key;
    private String  map;
    
    public Map(final int id, final String key, final String map){
        this.setId(id);
        this.setKey(key);
        this.setMap(map);
    }
    
    public Map(){
        this(0, "", "");
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(final int id){
        this.id = id;
    }
    
    public String getKey(){
        return this.key;
    }
    
    public void setKey(final String key){
        this.key = key;
    }
    
    public String getMap(){
        return this.map;
    }
    
    public void setMap(final String map){
        this.map = map;
    }
}
