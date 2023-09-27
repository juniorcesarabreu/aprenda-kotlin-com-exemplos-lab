// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val cpf: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) = 
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        
        if (usuario.nome.isNotEmpty() && inscritos.add(usuario)) {
            println("Usuário \"${usuario.nome.toUpperCase()}\" matriculado")
            true
        } else {
            println("Erro ao maticular usuário: $usuario")
            false
        }
        
	fun exibirMatriculados() {
        
        println("Matriculados em $nome:")
        for (inscrito in inscritos) {
            println("\t$inscrito")
        }
       
    }
    
    override fun toString(): String  = "Formação $nome, Nível $nivel" +
    									"\nConteúdos Educacionais:" +
    									conteudos.map {"\n\t$it"} +
    									"\nInscritos:" +
    									inscritos.map {"\n\t$it"}
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    println("DIO")
    
    val usuarioJunior = Usuario("Junior Cesar", "012345678-90")
    println(usuarioJunior)
    val usuarioCamila = Usuario("Camila Silva", "321654987-03")
    println(usuarioCamila)
    val usuarioPedro = Usuario("Pedro Alcantara", "741852963-07")
    println(usuarioPedro)
    val usuarioJessica = Usuario("Jessica Fernandes", "951623847-50")
    println(usuarioJessica)
    
    val cursoGit = ConteudoEducacional("Versionamento de Código com Git e GitHub", Nivel.BASICO, 60)
    println(cursoGit)
    val cursoIntroKotlin = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 
                                               Nivel.BASICO, 120)
    println(cursoIntroKotlin)
    val cursoInterfaceLayout = ConteudoEducacional("Princípios de Interface de Usuário e Layouts Android", 
                                               Nivel.INTERMEDIARIO, 120)
    println(cursoInterfaceLayout)
    val cursoRedesAndroid = ConteudoEducacional("Noções Básicas de Rede em Apps Android com Kotlin", 
                                               Nivel.INTERMEDIARIO, 120)
    println(cursoInterfaceLayout)
    
    val formacaoAndroid = Formacao("Android", Nivel.INTERMEDIARIO, listOf(
        cursoGit, cursoIntroKotlin, cursoInterfaceLayout, cursoRedesAndroid))
    println(formacaoAndroid)
    
    formacaoAndroid.matricular(Usuario("", ""))
	formacaoAndroid.matricular(usuarioJunior)
	formacaoAndroid.matricular(usuarioCamila)
	formacaoAndroid.matricular(usuarioPedro)
	formacaoAndroid.matricular(usuarioJessica)
    
    formacaoAndroid.exibirMatriculados()
    println(formacaoAndroid)
    
}