import PropTypes from "prop-types";

function ItemProduto(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.valor}</td>
            <td>{props.quantidade}</td>
        </tr>
    )
}

ItemProduto.propTypes = {
    nome: PropTypes.string.isRequired,
    valor: PropTypes.string.isRequired,
    quantidade: PropTypes.string.isRequired,
}

export default ItemProduto;