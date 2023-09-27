package projetoPessoal.Seriados.dto;


public record SerieResponseDTO(Long id, String title, String image, Integer level, String description) {

    public void setId(Long id){
        id=id;
    }
    public void setTitle(String title){
        title=title;
    }
    public void setImage(String image){
        image=image;
    }
    public void setLevel(Integer level){
        level=level;
    }
    public void setDescription(String description){
        description=description;
    }





}
