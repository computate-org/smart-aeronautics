echo hand written
find \
  ~/.local/src/smart-aeronautics/vars.yaml \
  ~/.local/src/smart-aeronautics/README.md \
  ~/.local/src/smart-aeronautics/src/main/java/org/computate/smartaeronautics/verticle/SiteRoutes.java \
      -type f -exec wc -l {} +
echo hand written
