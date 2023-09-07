
# 🏨 Challegens Hotel Alura 🏨
![Static Badge](https://img.shields.io/badge/Status-Parado-red?style=flat-square&logo=Github)
<br>
[![Linkerdin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/manoeldev-backend)
![java_badget](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![oracle_badget](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white)

<br>

## ⚠️ Avisos principais
* Marque esse projeto com uma ⭐ caso tenha gostado.
* Deem seu feedback caso achem algum error ou caso tenham alguma ideia de melhoria no projeto.
* Prestem atenção as orientações de como rodar o programa

<br>
<img src="https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/4f294b9d-d919-4827-9ea8-0062a5f21866" alt="esquilo_" width="150">

<br>

**Enfim vamos as apresentações:**

<br><br>

O **hotel alura** é um programa de criação de reservas para vagas de um hotel imaginario exclusivos para programadores. feito atraves do java Maven e utilizando do JFrame o Hotel Alura apresenta um interface simples e intuitiva para os consumidores, e cadastrar uma vaga nesse hotel não demora mais do que alguns minutos.
<br><br>

![Image da pagina Inicial do hotel alura](https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/2a7e04c0-7228-48e7-80d7-73c52518de9d)

## 🤖 API Utilizadas: 
* [JPA](https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager) 
* [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2) 
* [JCallendar](https://mvnrepository.com/artifact/com.toedter/jcalendar) 

<br>

O programa foi feito 100% apenas por eu (dono do repositorio). Apenas se baseando na interface grafica da Alura [Link para o repositorio base](https://github.com/alura-challenges/challenge-one-alura-hotel-br), com meus proprios codigos feitos para facilitar o entendimento dos codigos o maximo possivel:

```java
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, (int) (screenWidth * 0.6), screenHeight);
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);

    panel.add(JChallegensKeys.criarImagem(this.getClass().getClassLoader().getResource("imagens/Ha-100px.png"), 30, 30, 100,100));
    panel.add(JChallegensKeys.createText("LOGIN", 180, 80,new Font("Roboto", Font.BOLD, 25), new Color(8,136,198,255)));
    panel.add(JChallegensKeys.createText("USUARIO", 40, 130,new Font("Roboto", Font.BOLD, 25), new Color(8,136,198,255)));
    panel.add(usuarioInput);
    panel.add(JChallegensKeys.createText("SENHA", 40, 250,new Font("arial", Font.BOLD, 20), new Color(8,136,198,255)));
    panel.add(senhaInput);

    add(buttonConfirm);
```

## 🛠️ Principais características do projeto:
Além de um sistema de login funcional:
<br>usuario = "admin" 
<br>senha = "admin
<br><br>**O Hotel Alura a presenta muito mais funcionalidades, como:**

* Criação de Hospedes e Reservas 
* Acessar e visualizar os registro 
* Alteração e deletamento de registros 
* Interface simples e intuitiva

## 🖼️ Imagens do Projeto

### Menu principal
<img src="https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/6ae24ebb-4189-4483-87ab-17a87d40e216" alt="Menu Principal" width="500">
<br><br>

### Tela de Buscas
<img src="https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/44e0804f-3d71-485b-a661-146b66cd6a4e" alt="Tela de Buscas" width="500">
<br><br>

### Registo hóspedes
<img src="https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/bdfa9d8a-86da-4b00-8676-8cbf828ac49a" alt="Registo hóspedes" width="500">

<br><br>
## 💻 Como executar o aplicativo

O Primeiro passo é garantir que você possua o JDk 17 ou superior instalado em seu sistema, você pode baixar o jdk pelo proprio site da [Oracle](https://www.oracle.com/java/technologies/downloads/).
<br>
Apôs baixar e instalar a jdk o proximo passo vai ser baixar o repositorio. 

### Baixando o repositorio
Clique em "code":
<br>
![Tutorial_01](https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/ee4deeb6-dba1-4be0-99ce-9bc36ca90a1c)
<br><br>
Apos isso clique  em "baixar zip":
<br>
![Tutorial_02](https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/41799aec-dbc4-4055-a09b-a4975688dcac)
<br><br>
Abra o documento e extraia a pasta para area de trabalho:
<br>
![Tutorial_03](https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/0e3f35f6-3963-42d1-8be1-81d595808249)
<br><br>
Abra a pasta e clique 2 vezes no arquivo .jar:
<br>
![Tutorial_04](https://github.com/Manoelrev/hotel_alura_challegens/assets/92553052/fcf58a91-0a89-4a40-b783-db20153d594f)
<br><br>
E pronto, o programa em alguns momentos ira se abrir.

<br>
Esse programa foi feito como desafio do projeto Oracle Next Education (ONE), em parceria de Alura Latam e Oracle. Afim de apresentar os dominios dos alunos sobre os assuntos ensinados. 
