// vars/getServer.groovy
def call(serverName) {
    def XNODE1 = ['name':'xnode1', 'host':'152.32.168.223', 'sshKey':'xnode-key']
    def XNODE2 = ['name':'xnode2', 'host':'152.32.135.41', 'sshKey':'xnode-key']
    def XNODE3 = ['name':'xnode3', 'host':'103.72.145.76', 'sshKey':'xnode-key']
    def XNODE4 = ['name':'xnode4', 'host':'128.1.137.140', 'sshKey':'xnode-key']
    def GNODE1 = ['name':'gnode1', 'host':'mgr.vchat.club', 'sshKey':'gnode-key']
    def GNODE2 = ['name':'gnode2', 'host':'api1.vchat.club', 'sshKey':'gnode-key']
    def GNODE3 = ['name':'gnode3', 'host':'api2.vchat.club', 'sshKey':'gnode-key']
    def serverMap = ['xnode1':XNODE1, 'xnode2':XNODE2, 'xnode3':XNODE3, 'xnode4':XNODE4, 'gnode1':GNODE1, 'gnode2':GNODE2, 'gnode3':GNODE3]
    
    def remote = [:]
    remote.name = "${serverName}"
    remote.host = "serverMap.${serverName}.host"
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
    println("remote.user = ${remote.user}")
    println("remote.host = ${remote.host}")
    println(serverMap)
}
