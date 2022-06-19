def gitBranchName="master"
def repository=(gitRepo.split("/")[-1])[0..-5]

folder("${division}") {
    displayName("${division}")
    description("Folder for ${division}")
}

folder("${division}/${repository}") {
    displayName("${repository}")
    description("Folder for ${repository}")
}

pipelineJob("${division}/${repository}/${jobName}") {
    definition {
        cpsScm {
            scm {
              scriptPath("Jenkinsfile")
              git {
                  remote {
                      url("${gitRepo}")
                   	  name("origin")
                      credentials("gitreader")
                  }
                  branch("*/${gitBranchName}")
                  extensions {
                      cleanAfterCheckout()
                  }
              }
            }
        }
      logRotator(1, -1, 1, -1)
      description("Pipeline for ${division}/${repository}")
    }
}

listView("${division}") {
    description("Job listview for ${division}")
    jobs {
      name("${division}")
    }
    jobFilters {
        status {
            status(Status.UNSTABLE)
        }
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}