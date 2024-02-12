package Logic;

import Model.Routes;
import Model.referencePoints;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Control {

    // Lista de puntos que representan los vértices del grafo
    private List<referencePoints> points;

    // Lista de rutas que representan los bordes del grafo ponderado
    private List<Routes> routes;

    // Grafo ponderado que utiliza vértices de tipo referencePoints y bordes de tipo DefaultWeightedEdge
    private Graph<referencePoints, DefaultWeightedEdge> graph;

    // Instancia de DijkstraShortestPath para calcular el camino más corto en el grafo
    private DijkstraShortestPath<referencePoints, DefaultWeightedEdge> dijkstra;

    // Almacena el camino más corto calculado por el algoritmo de Dijkstra
    private GraphPath<referencePoints, DefaultWeightedEdge> shortestPath;

    /**
     * Constructor de la clase Control, inicializa los puntos de referencia y las posibles rutas
     * entre ellas, y crea el grafo que representa la red electrica.
     */
    public Control() {
        Points();
        Routes();
        Graph();
    }

        private void Points() {
            points = new ArrayList<>(Arrays.asList(
                    new referencePoints("Añoranzas"),
                    new referencePoints("Hotel Bella Tierra"),
                    new referencePoints("Cementerio"),
                    new referencePoints("Restaurante Boyaca Real"),
                    new referencePoints("Hotel Los Vagones"),
                    new referencePoints("Hospedaje Santa Elena"),
                    new referencePoints("San Benito"),
                    new referencePoints("Denticenter"),
                    new referencePoints("Restaurante Corazon de Melon"),
                    new referencePoints("Tiendas D1"),
                    new referencePoints("Parque Ecologico"),
                    new referencePoints("I.E Jorge Clemente Palacios"),
                    new referencePoints("Casa Motta"),
                    new referencePoints("Sabajon Don Joaquin"),
                    new referencePoints("Productos San Nicolas"),
                    new referencePoints("El Tenampa Club"),
                    new referencePoints("Hotel La Marquesa de Pinares")
            ));
        }


        private void Routes() {
            //Lista de posibles rutas encontradas entre ellas
            routes = new ArrayList<>(Arrays.asList(
                    //1
                    new Routes(points.get(0), points.get(1), 13),
                    new Routes(points.get(0), points.get(2), 9),
                    //2
                    new Routes(points.get(1), points.get(0), 13),
                    new Routes(points.get(1), points.get(3), 97),
                    //3
                    new Routes(points.get(2), points.get(0), 9),
                    new Routes(points.get(2), points.get(3), 58),
                    new Routes(points.get(2), points.get(4), 25),
                    //4
                    new Routes(points.get(3), points.get(1), 97),
                    new Routes(points.get(3), points.get(2), 58),
                    new Routes(points.get(3), points.get(4), 45),
                    new Routes(points.get(3), points.get(5), 38),
                    //5
                    new Routes(points.get(4), points.get(2), 25),
                    new Routes(points.get(4), points.get(3), 45),
                    new Routes(points.get(4), points.get(9), 60),
                    new Routes(points.get(4), points.get(12), 59),
                    new Routes(points.get(4), points.get(13), 82),
                    //6
                    new Routes(points.get(5), points.get(3), 38),
                    new Routes(points.get(5), points.get(6), 43),
                    new Routes(points.get(5), points.get(7), 20),
                    //7
                    new Routes(points.get(6), points.get(5), 43),
                    new Routes(points.get(6), points.get(7), 55),
                    new Routes(points.get(6), points.get(8), 63),
                    //8
                    new Routes(points.get(7), points.get(5), 20),
                    new Routes(points.get(7), points.get(6), 55),
                    new Routes(points.get(7), points.get(8), 51),
                    new Routes(points.get(7), points.get(9), 12),
                    //9
                    new Routes(points.get(8), points.get(6), 63),
                    new Routes(points.get(8), points.get(7), 51),
                    new Routes(points.get(8), points.get(10), 70),
                    //10
                    new Routes(points.get(9), points.get(4), 60),
                    new Routes(points.get(9), points.get(7), 12),
                    new Routes(points.get(9), points.get(12), 57),
                    new Routes(points.get(9), points.get(11), 29),
                    new Routes(points.get(9), points.get(10), 72),
                    //11
                    new Routes(points.get(10), points.get(8), 70),
                    new Routes(points.get(10), points.get(9), 72),
                    new Routes(points.get(10), points.get(11), 19),
                    new Routes(points.get(10), points.get(15), 75),
                    //12
                    new Routes(points.get(11), points.get(10), 19),
                    new Routes(points.get(11), points.get(9), 29),
                    new Routes(points.get(11), points.get(12), 55),
                    new Routes(points.get(11), points.get(14), 24),
                    new Routes(points.get(11), points.get(15), 34),
                    //13
                    new Routes(points.get(12), points.get(4), 59),
                    new Routes(points.get(12), points.get(9), 57),
                    new Routes(points.get(12), points.get(11), 55),
                    new Routes(points.get(12), points.get(13), 15),
                    //14
                    new Routes(points.get(13), points.get(4), 82),
                    new Routes(points.get(13), points.get(12), 15),
                    new Routes(points.get(13), points.get(14), 17),
                    new Routes(points.get(13), points.get(16), 86),
                    //15
                    new Routes(points.get(14), points.get(13), 17),
                    new Routes(points.get(14), points.get(11), 24),
                    new Routes(points.get(14), points.get(16), 93),
                    new Routes(points.get(14), points.get(15), 44),
                    //16
                    new Routes(points.get(15), points.get(14), 44),
                    new Routes(points.get(15), points.get(11), 34),
                    new Routes(points.get(15), points.get(10), 75),
                    new Routes(points.get(15), points.get(16), 98),
                    //17
                    new Routes(points.get(16), points.get(13), 86),
                    new Routes(points.get(16), points.get(14), 93),
                    new Routes(points.get(16), points.get(15), 98)

            ));

        }

    private void Graph() {
        // Crear un grafo ponderado utilizando la clase SimpleWeightedGraph de JGraphT
        graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Añadir vértices al grafo utilizando la lista de referencePoints
        for (referencePoints points1 : points) {
            graph.addVertex(points1);
        }

        // Añadir bordes y pesos al grafo utilizando la lista de Routes
        for (Routes route : routes) {
            // Añadir un borde entre el punto de inicio y el punto de destino
            graph.addEdge(route.getStartPoint(), route.getEndPoint());
            // Establecer el peso del borde con la distancia de la ruta
            graph.setEdgeWeight(graph.getEdge(route.getStartPoint(), route.getEndPoint()), route.getDistance());
        }
    }



    /**
     * Método para encontrar la ruta más corta entre dos puntos refernciados utilizando el
     * algoritmo de Dijkstra.
     */
    public String searchRoute(int origin, int destiny) {
        this.dijkstra = new DijkstraShortestPath<>(graph);// Crear una instancia de DijkstraShortestPath utilizando el grafo
        this.shortestPath = dijkstra.getPath(points.get(origin), points.get(destiny));// Obtener el camino más corto entre el punto de origen y el punto de destino

        String out = "";

        // Verificar si se encontró un camino más corto
        if (shortestPath != null) {
            // Construir la cadena de salida para la ruta más corta
            out += "La ruta más corta es: " + "\n";
            List<referencePoints> shortRoute = shortestPath.getVertexList();
            double shortestDistance = shortestPath.getWeight();
            // Iterar a través de los puntos en el camino más corto
            for (int i = 0; i < shortRoute.size() - 1; i++) {
                out += shortRoute.get(i).getNamePoint() + " -> ";
            }
            out += shortRoute.get(shortRoute.size() - 1).getNamePoint();// Agregar el último punto en la ruta
            out += "\nLa distancia de la ruta es:" + shortestDistance + " metros";
        } else {
            out += "\nNo se encontró una ruta.";
        }
        return out;
    }
}
