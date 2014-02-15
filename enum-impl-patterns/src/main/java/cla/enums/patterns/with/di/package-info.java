/**
 * <p>DI veut dire "dependency <i>injection</i>" mais est aussi parfois utilisé comme abbréviation de "dependency <i>inversion</i>"
 * L'inversion de dépendance consiste à faire dépendre la couche technique de la couche métier au lieu de l'inverse.
 * Ceci permet d'introduire de façon non-intrusive les préoccupations techniques.
 * (Une solution alternative pour éviter la pollution des préoccupations fonctionnelles par les préoccupations techniques est l'AOP)</p>
 * <p>Concrètement, le package métier com.toto.modele contient XXXEntity et XXXHelper/XXXServices/XXXEnvironment,
 * et le package technique com.toto.services contient XXXServicesImpl (par ex. un bean Spring transactionnel).</p>
 * */
package cla.enums.patterns.with.di;