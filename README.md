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

-   [Business Process Model and Notation](https://zh.wikipedia.org/zh-tw/%E4%B8%9A%E5%8A%A1%E6%B5%81%E7%A8%8B%E6%A8%A1%E5%9E%8B%E5%92%8C%E6%A0%87%E8%AE%B0%E6%B3%95)
    
-   [2022 Open Source BPM Comparison](https://medium.com/capital-one-tech/2022-open-source-bpm-comparison-33b7b53e9c98)
    
-   [Camunda Platform 7 documentation](https://docs.camunda.org/manual/7.19/)
    
-   [Camunda Platform REST API (7.19.1-ee)](https://docs.camunda.org/rest/camunda-bpm-platform/7.19/)
    
-   [GitHub] [camunda-bpm-spring-boot-starter](https://github.com/camunda/camunda-bpm-platform/tree/master/spring-boot-starter)
    
-   [GitHub] [Camunda Platform 7 - The open source BPMN platform](https://github.com/camunda/camunda-bpm-platform)
    
-   [GitHub] [External Task Client Spring Boot Starter: REST API & Webapp Example](https://github.com/camunda/camunda-bpm-examples/tree/7.19/spring-boot-starter/external-task-client/loan-granting-spring-boot-webapp)

### More information

-   [Activiti vs. Camunda Platform vs. Flowable Comparison Chart](https://sourceforge.net/software/compare/Activiti-vs-Camunda-vs-Flowable/)
    
-   [Don’t Underestimate the Power of Visual Content in your Digital Marketing Strategy](https://mastertcloc.unistra.fr/2019/07/22/digital-marketing-strategy/)
