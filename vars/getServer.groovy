// vars/getServer.groovy
def call(serverName) {
    def remote = [:]
    remote.name = 'gnode2'
    remote.host = 'api1.vchat.club'
    remote.allowAnyHosts = true
    withCredentials([sshUserPrivateKey(
            keyFileVariable:"key",
            credentialsId:"gnode-key",
            usernameVariable:"userName")]) {
        remote.user = userName
        remote.identityFile = key
    }
    println("serverName = ${serverName}")
    println("remote.name = ${remote.name}")
}
