## Spring Boot Web application with Camunda Webapps demo
### Run the application and use Camunda Webapps
- The BPMN model [simplified_version.bpmn](https://github.com/aliceyyang/camunda-demo/blob/master/src/main/resources/simplified_version.bpmn) is automatically deployed to the Process Engine since it is located under `/src/main/resources/`
- Other BPMN model are located under `src/main/resources/processes`
- You can access Camunda Webapps in browser: `http://localhost:8080` (provide login/password from `application.properties`, default: admin / admin)





### Camunda v.s. Flowable

|                   | Camunda                                                                                  | Flowable                                                                                       |
| ----------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| Community support | Active and growing ( approximately [37,326 commits](https://www.openhub.net/p/camunda) ) | Smaller and less active ( approximately [12,815 commits](https://www.openhub.net/p/flowable) ) |
| Performance       | Faster                                                                                   | Slower                                                                                         |
| Features          | More features, including PVM, Batch API, External Task, Node Properties,                 | Fewer features                                                                                 |
| Pricing           | More expensive                                                                           | Less expensive                                                                                 |
| Target audience   | Large organizations that need a powerful and scalable platform                           | Small and medium-sized organizations that need a cost-effective platform                       |
| Modeler           | Camunda Modeler / Web                                                                    | Plug-in in IDE / Web                                                                           |















### Camunda 7 v.s Camunda 8

|                 | Camunda 7                  | Camunda 8                            |
| --------------- | -------------------------- | ------------------------------------ |
| Positioning     | Private               | Sass                           |
| Workflow Engine | Process VM from Activiti 5 | Zeebe - cloud native workflow engine |
| Protocol        | REST API                   | gRPC                                 |
| Deployment mode | Embedded or remote         | Remote only                          |
| Database        | RDBMS                      | No database required                 |


### References
- [Camunda Platform 7 documentation](https://docs.camunda.org/manual/7.19/)
- [Camunda Platform 8 documentation](https://docs.camunda.io/)
- [2022 Open Source BPM Comparison](https://medium.com/capital-one-tech/2022-open-source-bpm-comparison-33b7b53e9c98)


### More information
- [Activiti vs. Camunda Platform vs. Flowable Comparison Chart](https://sourceforge.net/software/compare/Activiti-vs-Camunda-vs-Flowable/)
