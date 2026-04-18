echo AI generated
find \
  ~/.local/src/smart-aeronautics/pom.xml \
  ~/.local/src/smart-aeronautics/Containerfile \
  ~/.local/src/smart-aeronautics/pom.xml \
  ~/.local/src/smart-aeronautics/.gitignore \
  ~/.local/src/smart-aeronautics/bin/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/config/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/model/BaseModel.java \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/page/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/request/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/result/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/user/ \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/verticle/MainVerticle.java \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/verticle/WorkerVerticle.java \
  ~/.local/src/smart-aeronautics/src/main/resources/ \
  ~/.local/src/smart-aeronautics/src/gen/ \
  ~/.local/src/smart-aeronautics-static/webawesome/css/ \
  ~/.local/src/smart-aeronautics-static/webawesome/fiware/ \
  ~/.local/src/smart-aeronautics-static/webawesome/js/ \
  -type f -exec wc -l {} +
echo AI generated
