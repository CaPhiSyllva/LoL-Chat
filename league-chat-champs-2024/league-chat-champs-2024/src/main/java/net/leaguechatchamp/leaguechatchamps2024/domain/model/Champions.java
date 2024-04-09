package net.leaguechatchamp.leaguechatchamps2024.domain.model;

public record Champions(
    Long id,
    String name,
    String role,
    String lore,
    String imageUrl
) {
    public String generateContextByQuestion(String question){
        return """
        Pergunta: %s
        Nome do Campeão: %s
        Função: %s
        Lore do Campeão: %s

                """.formatted(question,this.name, this.role, this.lore);
    }

    public static Object stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }


    
}
