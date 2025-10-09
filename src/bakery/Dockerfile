# Estágio 1: Use uma imagem base com o JDK para compilar a aplicação (se necessário)
# Se você já compila o .jar na sua máquina local, pode pular direto para uma imagem JRE.
# Para este exemplo, vamos assumir que o .jar já foi gerado na pasta 'target'.

# Use uma imagem leve com o Java Runtime Environment (JRE) para rodar a aplicação.
# Certifique-se de que a versão do Java corresponde à do seu projeto (ex: 17, 11, etc.)
FROM openjdk:17-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo .jar compilado da sua pasta local 'target' para o contêiner
# O nome do .jar pode variar, então usamos um coringa (*)
COPY target/*.jar app.jar

# Expõe a porta que a aplicação Spring usa (padrão é 8080)
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]