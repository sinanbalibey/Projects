Bu proje, Spring Boot ve MongoDB kullanarak uygulamayı izlemek için Prometheus ve Grafana'yı nasıl yapılandırdığınızı göstermektedir.
Projeyi çalıştırmak için lokalinizde Mongo yüklü olması lazım. 
İlk olarak spring boot uygulamamızı ayağa kaldırıyoruz.
!!!src/main/resources/prometheus.yml dizinindeki targets adresine ipv4 adresinizi yazın
Sonra src/main/resource dizinine gidip "docker compose up -d" komutuyula prometheus ve grafanayı ayağa kaldırın.
(http://localhost:9090/) adresine gidip targets bölümünde projenin Up durumda olduğunu görün.

http://localhost:3000/ adresine gidip datasource olarak prometheus ekleyin.Url kısmına http://<ipv4adresiniz>:9090 adresini ekleyin.
Yeni bir dashboard import ederek izleme yapabilirsiniz.(Dashboardlar: https://grafana.com/grafana/dashboards/)
