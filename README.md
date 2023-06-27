# Urbanism

- Omar Shehada [shehadao@mcmaster.ca]
- Abdallah Alqashqish [alqashqa@mcmaster.ca]
- Beshoy Hezky [hezkyb@mcmaster.ca]

## Contributions / Authorship
*Features number meaning shown in the product backlog below*

- Omar worked on features: 2,4,10,16,17,18,20,21, creating cities, creating pathways between cities
- Beshoy worked on features: 1,3,4,5,7,8,9,11,12,13,15,19
- Abdallah worked on features: 1,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20

## How to run the product

### Installation instructions

This product is handled by Maven, as a multi-module project. We assume here that you have cloned the project in a directory named `A2`

To install the different tooling on your computer, simply run:

```
mosser@azrael A2 % mvn install
```

After installation, you'll find an application named `generator.jar` in the `generator` directory, a file named `visualizer.jar` in the `visualizer` one, and a file named `island.jar` in the `island` one.

### Generator

To run the generator, go to the `generator` directory, and use `java -jar` to run the product. The product takes one single argument (so far), the name of the file where the generated mesh will be stored as binary.

Generator options include:
1. -c,--color <vertex coloring> <segment coloring> <polygon coloring>   Sets the color generation for all the elements of the mesh.
2. -d,--dimension <widthxheight>                                        Sets the dimensions of the mesh.
3. -h,--help                                                            Displays program usage.
4. -m,--mesh <mesh type>                                                The type of mesh to generate. Either `grid` or `irregular`.
5. -np,--numPolygons <number of polygons>                               Sets the number of polygons to generate in the irregular mesh. Will be ignored if the mesh is a grid.
6. -out,--output <output file>                                          The file to output to.
7. -rl,--relaxationLevel <relaxation level>                             Sets the relaxation level of an irregular mesh. Will be ignored by grid mesh
8. -ss,--squareSize <square size>                                       Sets the size of the squares in the grid mesh. Ignored by irregular mesh.
9. -t,--thickness <vertex thickness> <segment thickness>                Sets the thickness for the vertices and segments.

```
mosser@azrael A2 % cd generator 
mosser@azrael generator % java -jar generator.jar -out sample.mesh -m grid (Generates a grid mesh)
mosser@azrael generator % java -jar generator.jar -out sample.mesh -m irregular (Generates an irregular mesh)
mosser@azrael generator % ls -lh sample.mesh
-rw-r--r--  1 mosser  staff    29K 29 Jan 10:52 sample.mesh
mosser@azrael generator % 
```

### Island Generator

To run the island generator, go to the `island` directory, and use `java -jar` to run the product.

Island Generator options include:
1. -i,--input <input file>                            Sets the file to read the mesh from.
2. -o,--output <output file>                          Sets the file to output the new island mesh to.
3. -h,--help                                          Displays program usage.
4. -m,--mode <mode>                                   The island generation mode. At the moment only `lagoon` and `random`.
5. -a,--altitude <altimetric profile>                 The island altimetric profile generation mode. At the moment only `lagoon`, `volcano`, or `hills`.
6. -l,--lakes <# of lakes>                            The number of lakes to place on the island. Note that lakes can merge.
7. -s,--shape <shape>                                 The shape to set the island to. Available shapes are `circle`, `oval`, and `star`.
8. -aq,--aquifers <# of aquifers>                     The number of random aquifers to add to the island.
9. -r, --rivers <# of rivers>                         The number of rivers to add to the island.
10. -s, --soil <absorption>                           The soil absorption profile to set for this island. Only `wet` and `dry`. Wet is the default.
11. -sed, --seed <seed>                               The seed of the island to generate. Generator will generate a random one if none are given.
12. -b, --biomes <biomes>                             The biomes of the island to generate. Options are `tropical` and `temperate`. Generator will generate a `tropical` island if none is given.
13. -H, --hook  <hook>                                Sets the hook to run after the generation of the island. Current options are `moisture` and `elevation`.
14. -set, --settlements <settlements number>          Sets the numbeer of `settlements` to be generated.
```
mosser@azrael A2 % cd island 
mosser@azrael island % java -jar island.jar -i ../generator/sample.mesh -o island.mesh -m lagoon
mosser@azrael island % java -jar island.jar -i ../generator/sample.mesh -o island.mesh -m random --shape circle --altitude volcano --biomes tropical # Generates a volcanic tropical island in the shape of a circle
mosser@azrael island % java -jar island.jar -i ../generator/sample.mesh -o island.mesh -m random --hook moisture # Moisture heatmap
mosser@azrael island % java -jar island.jar -i ../generator/sample.mesh -o island.mesh -m random --hook elevation # Elevation heatmap
mosser@azrael island % ls -lh island.mesh
-rw-r--r--  1 mosser  staff    29K 29 Jan 10:52 sample.mesh
mosser@azrael island % 
```

### Visualizer

To visualize an existing mesh, go to the `visualizer` directory, and use `java -jar` to run the product. The product take two arguments (so far): the file containing the mesh, and the name of the file to store the visualization (as an SVG image).

Visualizer options include:
1. -h,--help                      Displays program usage.
2. -in,--input <input file>       Takes in the mesh file to read from.
3. -out,--output <output file>    The file to output to.
4. -X,--debug                     Enable debug mode when rendering the mesh.

```
mosser@azrael A2 % cd visualizer 
mosser@azrael visualizer % java -jar visualizer.jar -in ../generator/sample.mesh -out sample.svg
mosser@azrael visualizer % java -jar visualizer.jar -in ../generator/sample.mesh -out sample.svg -X (For debugging mode)

... (lots of debug information printed to stdout) ...

mosser@azrael visualizer % ls -lh sample.svg
-rw-r--r--  1 mosser  staff    56K 29 Jan 10:53 sample.svg
mosser@azrael visualizer %
```
To viualize the SVG file:

- Open it with a web browser
- Convert it into something else with tool slike `rsvg-convert`

### Pathfinder

The `pathfinder` package includes a graph ADT and a pathfinding algorithm to find the shortest path between 2 nodes. You can represent any graph problem using this package.

Pathfinder features include:
1. Edge<T>: An edge created through 2 nodes of any type T.
   -There are 2 implementations of edges: directed and undirected, and both can be weighted/unweighted.
2. Graph<T>: A graph that contains nodes and edges of any type T.
   -There are 2 implementations of graphs: directed and undirected, and both can be weighted/unweighted.
   NOTE: one cannot use directed edges to construct an undirected graph and vice versa.
3. Pathfinder<T>: An interface which makes the classes the implement it specify a shortest path algorithm.
   -The AbstractGraph<T> class implements Dijkstra's algorithm to find the shortest path between any 2 nodes,
   which can be used on directed and undirected graphs(negative edges excluded).

Full developer documentation is included to show what each method and constructor does.

## How to contribute to the project

When you develop features and enrich the product, remember that you have first to `package` (as in `mvn package`) it so that the `jar` file is re-generated by maven.

Any feature or code that uses randoms uses a seed specified by the user or created randomly at runtime. When you build upon the existing code, make sure you use
random instances generated by the seed and not new ones.

## Backlog

 Id | Feature title | Who? | Start | End | Status |
- | 01 |Creating a mesh ADT (fix generator) |Abdallah,Beshoy| 8-2-2023 | 16-2-2023 | Complete |
- | 02 |Producing full meshes |Omar | 8-2-2023 | 16-2-2023 | Complete |
- | 03 |Playing with rendering |Beshoy | 16-2-2023 | 16-2-2023 | Complete |
- | 04 |Visualization mode |Omar | 16-2-2023 | 17-2-2023 | Complete |
- | 05 |Mesh configuration |Abdallah,Beshoy| 19-2-2023 | 21-2-2023 | Complete |
- | 04 |Irregular mesh generation |Omar & Beshoy | 22-2-2023 | 25-2-2023 | Complete |
- | 05 |Tile System |Abdallah&Beshoy| 01-3-2023 | 03-3-2023 | Complete |
- | 06 |Lagoon Tile |Abdallah&Beshoy| 03-3-2023 | 04-3-2023 | Complete |
- | 07 |Beach Tile |Abdallah&Beshoy| 03-3-2023 | 04-3-2023 | Complete |
- | 08 |Ocean Tile |Abdallah&Beshoy| 03-3-2023 | 04-3-2023 | Complete |
- | 09 |Land Tile |Abdallah&Beshoy| 03-3-2023 | 04-3-2023 | Complete |
- | 10 |Input Handling |Omar | 01-3-2023 | 03-3-2023 | Complete |
- | 11 |Lagoon Island Generation |Abdallah&Beshoy| 01-3-2023 | 03-3-2023 | Complete |
- | 12 |Island Shape Generation |Abdallah&Beshoy| 03-3-2023 | 10-3-2023 | Complete |
- | 13 |Island Lake Generation |Abdallah&Beshoy| 03-3-2023 | 14-3-2023 | Complete |
- | 14 |Island Elevation Generation |Abdallah | 03-3-2023 | 12-3-2023 | Complete |
- | 15 |Island Aquifer Generation |Abdallah&Beshoy| 16-3-2023 | 20-3-2023 | Complete |
- | 16 |Island River Generation |Abdallah&Omar | 20-3-2023 | 25-3-2023 | Complete |
- | 17 |Island Humidity Generation |Abdallah&Omar | 20-3-2023 | 26-3-2023 | Complete |
- | 18 |Island Soil Absorption |Abdallah&Omar | 23-3-2023 | 26-3-2023 | Complete |
- | 19 |Island Seeded Generation |Abdallah&Beshoy| 23-3-2023 | 26-3-2023 | Complete |
- | 20 |Island Biomes and Whittaker Diagrams |Abdallah&Omar | 26-3-2023 | 26-3-2023 | Complete |
- | 21 |Island moisture and elevation heatmaps|Omar | 26-3-2023 | 26-3-2023 | Complete |

### Definition of Done

1. Works as expected per feature outline and requirements
2. No bugs and unexpected behaviour
3. Smooth program execution
