# amit_spring_boot_repositories_sample
amit_spring_boot_repositories_sample
amit.txt


Spring data common project declares below repository interfaces!
  1. Repository<T, Id extends Serializable>
  2. CurdRepository<T, Id extends Serializable>
  3. PagingAndSortingRepository<T, Id extends Serializable>
  4. QueryDslPredicateExecutor<T>  it's not repository interface but it help in executing the Dsl queryies on the underlying datastore based on DSL predicate to retrieve the database objects


Spring data jpa project declares the below repository interfaces that are specific to the jpa-provider persistance layer
  1. JpaRepository<T, Id extends serializable>
  2. JpaSpecificationExecutor<T> interface is not repository interface. it declares the method that can be used to retrieve the entities from the database by using Specification<T> objects that uses the JPA criteria API

Referenced docs are
1. https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction/
2. Spring offical docs
