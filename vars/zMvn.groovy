// vars/zMvn.groovy
def call(mvnExec) {
    configFileProvider([configFile(fileId: 'maven-global-settings', variable: 'MAVEN_GLOBAL_SETTINGS')]){
        sh "mvn -s ${MAVEN_GLOBAL_SETTINGS} ${mvnExec}"
    }
}