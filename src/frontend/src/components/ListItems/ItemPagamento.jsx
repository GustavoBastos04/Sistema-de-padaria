import PropTypes from "prop-types";

function ItemPagamento(props){
    return (
        <tr>
            <td>{props.cpf_cliente}</td>
            <td>{props.forma}</td>
        </tr>
    )
}

ItemPagamento.propTypes = {
    cpf_cliente: PropTypes.string.isRequired,
    forma: PropTypes.string.isRequired,
}

export default ItemPagamento;