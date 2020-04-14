***** Para instalar vai precisar também do:

JavaFX SDK - https://gluonhq.com/products/javafx/
Java JDK - https://www.oracle.com/java/technologies/javase-jdk8-downloads.html


****** Passos para a instalação:

1º - Instalar o Java JDK

2° - Configurar as variáveis de ambiente com o nome "JAVA_HOME" e com caminho (ex: C:\Program Files\Java\jdk-11.0.3) e a variável "HOME_JAVA_BIN"

3º - Criar uma pasta java -> libs -> e colar o JavaFX SDK (javafx-sdk)

4º - Configurar a variável de ambiente com o nome "PATH_TO_FX" e com caminho (ex: C:\java-libs\javafx-sdk\lib) 

5º - Copiar o arquivo JAR principal e o arquivo de conexão com o banco de dados "db.properties" para uma pasta qualquer


***** Rodar a aplicação: 

Abrir o CMD ir para a pasta que salvou o JAR principal, executar o comando: java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -cp Projeto com JavaFX e JDBC.jar application.Main 

OU

Criar um arquivo .bat com o comando: java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -cp Projeto com JavaFX e JDBC.jar application.Main 


***** Criar ataho:
Criar atalho normal e em propiedades -> atalho -> iniciar em: caminho da pasta JAR, e Destino: o comando:java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -cp Projeto com JavaFX e JDBC.jar application.Main

Ou o comando para não aparecer o cmd quando rodar a aplicação: start javaw --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -cp Projeto com JavaFX e JDBC.jar application.Main