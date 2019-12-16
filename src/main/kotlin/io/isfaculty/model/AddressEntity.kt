package io.isfaculty.model

import javax.persistence.*

@Entity
@Table(name = "address", schema = "public")
class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, nullable = false)
    var addressId: Long? = null

    @ManyToOne(targetEntity = HumanEntity::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_human", referencedColumnName = "id_human")
    var humanEntity: HumanEntity? = null

    @Column(name = "country", nullable = false)
    var country: String? = null

    @Column(name = "street", nullable = false)
    var street: String? = null

    @Column(name = "house", nullable = false)
    var house: Int? = null

    @Column(name = "building")
    var building: Int? = null

    @Column(name = "flat", nullable = false)
    var flat: Int? = null

    @Column(name = "city", nullable = false)
    var city: String? = null

    @Column(name = "legal_address", nullable = false)
    var legalAddress: Boolean? = null

}